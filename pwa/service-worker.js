const cacheName = "FREEPY_V1";
const OFFLINE_FILES = [
  "/manifest.json",
  "/images/favicon.ico",
];

const OFFLINE_URL = 'offline.html';
const OFFLINE_IMG = '/images/network.png';


self.addEventListener('install', (event) => {
    event.waitUntil((async () => {
        const cache = await caches.open(cacheName);
        await cache.addAll(OFFLINE_FILES);
        await cache.add(new Request(OFFLINE_IMG));
        await cache.add(new Request(OFFLINE_URL, {cache: 'reload'}));
    })());
});

self.addEventListener('activate', (event) => {
    event.waitUntil((async () => {
        if ('navigationPreload' in self.registration) {
            await self.registration.navigationPreload.enable();
        }
    })());
    self.clients.claim();
});

self.addEventListener('fetch', (event) => {
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
                console.log('Fetch failed; returning offline page instead.', error);

                const cache = await caches.open(cacheName);
                const cachedResponse = await cache.match(OFFLINE_URL);
                return cachedResponse;
            }
        })());
    }
});

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