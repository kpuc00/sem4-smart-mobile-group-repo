import SwiftUI

struct FamilyPlusView: View {
    var items: [GridItem] = Array(repeating: .init(.adaptive(minimum: 150), spacing: 0), count: 2)
    
    private let twoColumnGrid = [
        GridItem(.adaptive(minimum: 180), spacing: 0),
        GridItem(.adaptive(minimum: 180), spacing: 0)
        
    ]
    
    var body: some View {
        ScrollView{
            LazyVGrid(columns: twoColumnGrid){
                Button(action: { print("btn_1 clicked") }, label : {
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
                
                
                Button(action: { print("btn_2 clicked") }, label : {
                    VStack(alignment: .center, spacing: nil, content: {
                        Image(systemName: "mic.fill")
                            .resizable()
                            .frame(width: 35, height: 50, alignment: .center)
                        Text("Voice Memoirs")
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
                
                Button(action: { print("btn_3 clicked") }, label : {
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
                
                Button(action: { print("btn_4 clicked") }, label : {
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
    }
}

struct FamilyPlusView_Previews: PreviewProvider {
    static var previews: some View {
        FamilyPlusView()
    }
}
