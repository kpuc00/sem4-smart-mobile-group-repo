import SwiftUI

struct FamilyPlusView: View {
    var items: [GridItem] = Array(repeating: .init(.adaptive(minimum: 150), spacing: 0), count: 2)
    
    private let twoColumnGrid = [
        GridItem(.adaptive(minimum: 180), spacing: 0),
        GridItem(.adaptive(minimum: 180), spacing: 0)
        
    ]
    @State private var goToMap = false
    @State private var goToAudioMemoir = false
    @State private var goToFamilyHistory = false
    @State private var goToFamilyTree = false
    var body: some View {
        ScrollView{
            NavigationLink("", destination: Map(), isActive: $goToMap)
            NavigationLink("", destination: AudioMemoirView(), isActive: $goToAudioMemoir)
            NavigationLink("", destination: FamilyHistoryView(), isActive: $goToFamilyHistory)
            NavigationLink("", destination: FamilyTreeView(), isActive: $goToFamilyTree)
            LazyVGrid(columns: twoColumnGrid){
                Button(action: {  self.goToMap.toggle()}, label : {
                    VStack(alignment: .center, spacing: 0, content: {
                        
                        Image(systemName: "map.fill")
                            .resizable()
                            .frame(width: 50, height: 50, alignment: .center)
                        Text("Family Map")
                            .font(.title)
                            .multilineTextAlignment(.center)
                    })
                })
                .accentColor(.white)
                .frame(width: 180, height: 180)
                .background(Color.yellow)
                .shadow(color: Color.black.opacity(0.3),
                        radius: 3,
                        x: 3,
                        y: 3)
                .cornerRadius(30)
                .navigate(to: Map(), when: $goToMap)
                
                
                
                Button(action: { self.goToAudioMemoir.toggle() }, label : {
                    VStack(alignment: .center, spacing: nil, content: {
                        Image(systemName: "mic.fill")
                            .resizable()
                            .frame(width: 35, height: 50, alignment: .center)
                        Text("Audio Memoir")
                            .font(.title)
                            .multilineTextAlignment(.center)
                    })
                })
                .accentColor(.white)
                .frame(width: 180, height: 180, alignment: .center)
                .background(Color.yellow)
                .shadow(color: Color.black.opacity(0.3),
                        radius: 3,
                        x: 3,
                        y: 3)
                .cornerRadius(30)
                
                Button(action: { self.goToFamilyHistory.toggle() }, label : {
                    VStack(alignment: .center, spacing: nil, content: {
                        Image(systemName: "book.fill")
                            .resizable()
                            .frame(width: 55, height: 40, alignment: .center)
                        Text("Family History")
                            .font(.title)
                            .multilineTextAlignment(.center)
                    })
                })
                .accentColor(.white)
                .frame(width: 180, height: 180, alignment: .center)
                .background(Color.yellow)
                .shadow(color: Color.black.opacity(0.3),
                        radius: 3,
                        x: 3,
                        y: 3)
                .cornerRadius(38.5)
                
                Button(action: { self.goToFamilyTree.toggle() }, label : {
                    VStack(alignment: .center, spacing: nil, content: {
                        Image(systemName: "arrow.branch")
                            .resizable()
                            .frame(width: 50, height: 50, alignment: .center)
                        Text("Family Tree")
                            .font(.title)
                            .multilineTextAlignment(.center)
                    })
                })
                .accentColor(.white)
                .frame(width: 180, height: 180, alignment: .center)
                .background(Color.yellow)
                .shadow(color: Color.black.opacity(0.3),
                        radius: 3,
                        x: 3,
                        y: 3)
                .cornerRadius(38.5)
            }
        }
//        .navigate(to: Map(), when: $goToMap)
    }
}

extension View {

    /// Navigate to a new view.
    /// - Parameters:
    ///   - view: View to navigate to.
    ///   - binding: Only navigates when this condition is `true`.
    func navigate<NewView: View>(to view: NewView, when binding: Binding<Bool>) -> some View {
        NavigationView {
            ZStack {
                self
                    .navigationBarTitle("")
                    .navigationBarHidden(true)

                NavigationLink(
                    destination: view
                        .navigationBarTitle("")
                        .navigationBarHidden(true),
                    isActive: binding
                ) {
                    EmptyView()
                }
            }
        }
    }
}

struct FamilyPlusView_Previews: PreviewProvider {
    static var previews: some View {
        FamilyPlusView()
    }
}
