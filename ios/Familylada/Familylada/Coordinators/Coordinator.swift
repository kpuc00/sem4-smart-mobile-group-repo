import Foundation
import MapKit

final class Coordinator: NSObject, MKMapViewDelegate{
    var control: MapView
    init(_ control: MapView) {
        self.control = control
    }
}
