//
//  ProfileView.swift
//  Familylada
//
//  Created by Kristiyan Strahilov on 12.05.21.
//

import SwiftUI

struct ProfileView: View {
    @State private var text = ""
    
    var body: some View {
        ScrollView(showsIndicators: false) {
            HStack {
                VStack {
                    Image(uiImage: "https://robohash.org/mollitiavelitasperiores.png?size=50x50&set=set1".load()).resizable().frame(width: 120, height: 120, alignment: .center)
                    Button(action: {
                        
                    }) {
                        Text("Change photo")
                    }
                }
            }
            HStack {
                VStack(alignment: .leading) {
                    Text("Bio")
                    TextField("type something...", text: $text).disableAutocorrection(true)
                }
            }
            HStack {
                Text("Hobbies").font(.title)
                    Button(action: {
                        print("add hobbies clicked")
                    }, label: {
                        Text("+")
                            .font(.system(.title))
                            .frame(width: 37, height: 30)
                            .foregroundColor(Color.white)
                            .padding(.bottom, 7)
                    })
                    .background(Color.yellow)
                    .cornerRadius(38.5)
                    .padding()
                    .shadow(color: Color.black.opacity(0.3), radius: 3, x: 3, y: 3)
            }
            HStack {
                Text("Football").padding(6).border(Color.black, width: 1)
                Text("Keanu Reeves").padding(6).border(Color.black, width: 1)
                Text("Pop music").padding(6).border(Color.black, width: 1)
                Text("Golf").padding(6).border(Color.black, width: 1)
            }
        }.padding()
        .navigationTitle("Nance Reddington")
    }
}

struct ProfileView_Previews: PreviewProvider {
    static var previews: some View {
        ProfileView()
    }
}
