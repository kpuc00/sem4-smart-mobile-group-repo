import SwiftUI
import MapKit

struct MapView: UIViewRepresentable {
    
    
    func makeUIView(context: Context) -> MKMapView {
        let map = MKMapView()
        map.showsUserLocation = true
        map.delegate = context.coordinator
        let pin1 = MKPointAnnotation()
        let pin2 = MKPointAnnotation()
        let pin3 = MKPointAnnotation()
        let pin4 = MKPointAnnotation()
        pin1.coordinate = CLLocationCoordinate2D(latitude: 69.4207, longitude: 17.8919)
        pin1.title = "Bruce Wayne"
        pin2.coordinate = CLLocationCoordinate2D(latitude: 12.6335, longitude: 41.8929)
        pin2.title = "Liland Thorne"
        pin3.coordinate = CLLocationCoordinate2D(latitude: 45.6335, longitude: 19.8929)
        pin3.title = "Martha Wayne"
        pin4.coordinate = CLLocationCoordinate2D(latitude: 32.6335, longitude: 55.5555)
        pin4.title = "Thomas Dimp"
        map.addAnnotation(pin1)
        map.addAnnotation(pin2)
        map.addAnnotation(pin3)
        map.addAnnotation(pin4)
        return map
    }
    
    func makeCoordinator() -> Coordinator {
        Coordinator(self)
    }
    
    func updateUIView(_ uiView: MKMapView, context: UIViewRepresentableContext<MapView>) {
        
    }
}
