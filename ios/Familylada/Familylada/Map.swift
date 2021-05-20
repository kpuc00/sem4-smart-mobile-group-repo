import SwiftUI

struct Map: View {
    
    private var lm = LocationManager()
    
    var body: some View {
        MapView()
            .navigationTitle("Family map")
            .ignoresSafeArea()
    }
}

struct Map_Previews: PreviewProvider {
    static var previews: some View {
        MapView()
    }
}
