import Combine
import SwiftUI


class DataSource: ObservableObject {
    let didChange = PassthroughSubject<Void, Never>()
    var pictures = [String]()
    
    init() {
        let fm = FileManager.default
        if let path =
            Bundle.main.resourcePath, let
                items = try?
                fm.contentsOfDirectory(atPath: path){
            for item in items {
                if item.hasPrefix("ep") {
                    pictures.append(item)
                }
            }
            
        }
        didChange.send(())
    }
}

struct DetailedView: View {
    var selectedImage: String
    @State private var hideNavigationBar = false
    
    var body: some View {
        let img = UIImage(named: selectedImage)!
        return Image(uiImage: img)
            .resizable()
            .scaledToFit()
            .navigationBarTitle(Text(selectedImage), displayMode: .inline)
            .navigationBarHidden(hideNavigationBar)
            .onTapGesture {
                self.hideNavigationBar.toggle()
            }
    }
}

struct PicturesView: View {
    @ObservedObject var ds = DataSource()
    
    var body: some View {
        List(ds.pictures, id: \.self) { picture
            in
            NavigationLink(destination: DetailedView(selectedImage: picture)) {
                Text(picture)
            }
            
        }
    }
}

struct GalleryView: View {
    let renders: [Int] = [1, 2]
    
    var body: some View {
        List {
            ForEach(renders, id: \.self) {
                render in
                
                    NavigationLink(destination: PicturesView()) {
                        Image("albumCover")
                            .resizable()
                            .aspectRatio(contentMode: .fit)
                            .frame(width: 150, height: 180)
                        Spacer()
                            .frame(width: 20)
                        Text("Bacelona")
                            .font(.title)
                    }
                    
                   
                
                
            }
        }
    }
}

struct GalleryView_Previews: PreviewProvider {
    static var previews: some View {
        GalleryView()
    }
}
