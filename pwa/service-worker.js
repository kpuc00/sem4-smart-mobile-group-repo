const cacheName = "FREEPY_V1";
const appFiles = [
  "/manifest.json",
  "/js/scripts.js",
  "/css/style.css",
  "/images/favicon.ico",
  "/images/ph.jpg",
  "/images/sst.jpg",
  "offline.html"
];

const OFFLINE_URL = 'offline.html';

self.addEventListener('install', (event) => {
    event.waitUntil((async () => {
        const cache = await caches.open(cacheName);
        // Setting {cache: 'reload'} in the new request will ensure that the response
        // isn't fulfilled from the HTTP cache; i.e., it will be from the network.
        await cache.add(new Request(OFFLINE_URL, {cache: 'reload'}));
    })());
});

self.addEventListener('activate', (event) => {
    event.waitUntil((async () => {
        // Enable navigation preload if it's supported.
        // See https://developers.google.com/web/updates/2017/02/navigation-preload
        if ('navigationPreload' in self.registration) {
            await self.registration.navigationPreload.enable();
        }
    })());

    // Tell the active service worker to take control of the page immediately.
    self.clients.claim();
});

self.addEventListener('fetch', (event) => {
    // We only want to call event.respondWith() if this is a navigation request
    // for an HTML page.
    if (event.request.mode === 'navigate') {
        event.respondWith((async () => {
            try {
                // First, try to use the navigation preload response if it's supported.
                const preloadResponse = await event.preloadResponse;
                if (preloadResponse) {
                    return preloadResponse;
                }

                const networkResponse = await fetch(event.request);
                return networkResponse;
            } catch (error) {
                // catch is only triggered if an exception is thrown, which is likely
                // due to a network error.
                // If fetch() returns a valid HTTP response with a response code in
                // the 4xx or 5xx range, the catch() will NOT be called.
                console.log('Fetch failed; returning offline page instead.', error);

                const cache = await caches.open(cacheName);
                const cachedResponse = await cache.match(OFFLINE_URL);
                return cachedResponse;
            }
        })());
    }

    // If our if() condition is false, then this fetch handler won't intercept the
    // request. If there are any other fetch handlers registered, they will get a
    // chance to call event.respondWith(). If no fetch handlers call
    // event.respondWith(), the request will be handled by the browser as if there
    // were no service worker involvement.
});


// self.addEventListener('fetch', function(event) {
//     event.respondWith(
//         caches.match(event.request)
//             .then(function(response) {
//                 // Cache hit - return response
//                 if (response) {
//                     return response;
//                 }
//
//                 return fetch(event.request).then(
//                     function(response1) {
//                         // Check if we received a valid response
//                         if(!response1 || response1.status !== 200 || response1.type !== 'basic') {
//                             return response1;
//                         }
//
//                         // IMPORTANT: Clone the response. A response is a stream
//                         // and because we want the browser to consume the response
//                         // as well as the cache consuming the response, we need
//                         // to clone it so we have two streams.
//                         var responseToCache = response1.clone();
//
//                         caches.open(cacheName)
//                             .then(function(cache) {
//                                 cache.put(event.request, responseToCache);
//                             });
//
//                         return response1;
//                     }
//                 );
//             })
//             // .catch(function (error){
//             //     return "/offline.html"
//             // })
//     );
// });

self.addEventListener("push", (pushing) => {
  if(pushing.data){
     let pushdata=JSON.parse(pushing.data.text());
    console.log("Service Worker: I received this:",pushdata);
    if((pushdata["title"]!=="")&&(pushdata["message"]!=="")){
      const options={ body:pushdata["message"] }
      self.registration.showNotification(pushdata["title"],options);
      console.log("Service Worker: I made a notification for the user");
    } else {
      console.log("Service Worker: I didn't make a notification for the user, not all the info was there :(");
    }
  }
});

self.addEventListener("notificationclick",function(clicking){
  const pageToOpen="/";
  const promiseChain=clients.openWindow(pageToOpen);
  event.waitUntil(promiseChain);
});