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
        pin1.coordinate = CLLocationCoordinate2D(latitude: 69.6335, longitude: 2.8929)
        pin1.title = "Bruce Wayne"
        pin2.coordinate = CLLocationCoordinate2D(latitude: 12.6335, longitude: 26.8929)
        pin2.title = "Liland Thorne"
        pin3.coordinate = CLLocationCoordinate2D(latitude: 65.6335, longitude: 29.8929)
        pin3.title = "Martha Wayne"
        pin4.coordinate = CLLocationCoordinate2D(latitude: 32.6335, longitude: 22.8829)
        pin4.title = "Thomas Dimp"
        map.addAnnotation(pin1)
        return map
    }
    
    func makeCoordinator() -> Coordinator {
        Coordinator(self)
    }
    
    func updateUIView(_ uiView: MKMapView, context: UIViewRepresentableContext<MapView>) {
        
    }
}
