//
//  MembersView.swift
//  Familylada
//
//  Created by Kristiyan Strahilov on 12.05.21.
//

import SwiftUI

struct MembersView: View {
    @State private var text = ""
    
    let users = [
        ("Nance Reddington", "https://robohash.org/mollitiavelitasperiores.png?size=50x50&set=set1"),
        ("Stanly Tetlow", "https://robohash.org/tenetursuntminus.png?size=50x50&set=set1"),
        ("Josh Hasnip", "https://robohash.org/auttemporerecusandae.png?size=50x50&set=set1"),
        ("Gabbie Condell", "https://robohash.org/idvoluptastenetur.png?size=50x50&set=set1"),
        ("Filberto Britto", "https://robohash.org/doloreetquia.png?size=50x50&set=set1"),
        ("Maggee Gittings", "https://robohash.org/nesciunteiussimilique.png?size=50x50&set=set1"),
        ("Conni Linforth", "https://robohash.org/facilisillodolore.png?size=50x50&set=set1"),
        ("Stearne McHugh", "https://robohash.org/modiquisquamfuga.png?size=50x50&set=set1"),
        ("Friedrick Nellen", "https://robohash.org/sequiipsalaudantium.png?size=50x50&set=set1"),
        ("Lorettalorna de Merida", "https://robohash.org/nequeetvoluptas.png?size=50x50&set=set1")
    ]
    
    let layout = [
        GridItem(.adaptive(minimum: 100))
    ]
    
    var body: some View {
        ScrollView(showsIndicators: false) {
            HStack {
                Image(systemName: "magnifyingglass")
                TextField("Search...", text: $text).disableAutocorrection(true)
            }.padding().overlay(Capsule(style: .continuous).stroke(Color.gray)).padding()
            
            LazyVGrid(columns: layout, spacing: 20) {
                ForEach(0..<users.count) {
                    let index = $0
                    VStack {
                        Image(uiImage: users[index].1.load()).resizable().frame(width: 100, height: 100, alignment: .center)
                        Text(users[index].0).multilineTextAlignment(.center)
                    }
                }
            }.padding()
        }
    }
}

struct MembersView_Previews: PreviewProvider {
    static var previews: some View {
        MembersView()
    }
}
