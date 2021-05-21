import SwiftUI

struct Map: View {
    
    private var lm = LocationManager()
    
    var body: some View {
        MapView()
            .ignoresSafeArea()
            .navigationTitle("Family map")
            .navigationBarTitleDisplayMode(.inline)
    }
}

struct Map_Previews: PreviewProvider {
    static var previews: some View {
        MapView()
    }
}
