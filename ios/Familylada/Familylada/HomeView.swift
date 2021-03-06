//
//  HomeView.swift
//  Familylada
//
//  Created by Kristiyan Strahilov on 12.05.21.
//

import SwiftUI

struct HomeView: View {
    var body: some View {
        ScrollView {
            Spacer()
            HStack {
                VStack {
                    HStack {
                        Image(uiImage: "https://robohash.org/tenetursuntminus.png?size=50x50&set=set1".load()).resizable().frame(width: 30, height: 30)
                        Text("Stanly Tetlow")
                        Spacer()
                    }
                    HStack {
                        Text("What a lovely day!")
                        Spacer()
                    }.padding()
                }
            }.padding().background(Color.white).clipped().shadow(radius: 3)
            
            HStack {
                VStack {
                    HStack {
                        Image(uiImage: "https://robohash.org/nesciunteiussimilique.png?size=50x50&set=set1".load()).resizable().frame(width: 30, height: 30)
                        Text("Maggee Gittings")
                        Spacer()
                    }
                    VStack {
                        HStack {
                            Text("My last trip to the ocean")
                            Spacer()
                        }
                        Image("sea").resizable().scaledToFit()
                    }
                }
            }.padding().background(Color.white).clipped().shadow(radius: 3)
            HStack {
                VStack {
                    HStack {
                        Image(uiImage: "https://robohash.org/idvoluptastenetur.png?size=50x50&set=set1".load()).resizable().frame(width: 30, height: 30)
                        Text("Gabbie Condell")
                        Spacer()
                    }
                    HStack {
                        Image("family").resizable().scaledToFit()
                    }
                }
            }.padding().background(Color.white).clipped().shadow(radius: 3)
        }
    }
}

struct HomeView_Previews: PreviewProvider {
    static var previews: some View {
        HomeView()
    }
}
