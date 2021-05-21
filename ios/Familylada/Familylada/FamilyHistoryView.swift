//
//  FamilyHistoryView.swift
//  Familylada
//
//  Created by Kristiyan Strahilov on 20.05.21.
//

import SwiftUI

struct FamilyHistoryView: View {
    @State private var text = ""
    
    var body: some View {
        ScrollView {
            HStack {
                Image(systemName: "magnifyingglass")
                TextField("Search...", text: $text).disableAutocorrection(true)
            }.padding().overlay(Capsule(style: .continuous).stroke(Color.gray)).padding()
            
            HStack {
                VStack(alignment: .leading) {
                    Text("Bill's big success").font(.title3)
                    Text("Looking back to 1913 when ...").font(.caption)
                    Spacer()
                    Button(action: {}, label : {Text("Read more")})
                }.padding()
                Spacer()
                Image("history1").resizable().scaledToFit().frame(width: 150, alignment: .center)
            }.background(Color.white).clipped().shadow(radius: 3)
            
            HStack {
                VStack(alignment: .leading) {
                    Text("Margharet's childhood").font(.title3)
                    Text("Margharet was born in 1902 in Germany...").font(.caption)
                    Spacer()
                    Button(action: {}, label : {Text("Read more")})
                }.padding()
                Spacer()
                Image("history2").resizable().scaledToFit().frame(width: 150, alignment: .center)
            }.background(Color.white).clipped().shadow(radius: 3)
            
            HStack {
                VStack(alignment: .leading) {
                    Text("The life of Steven Dorris").font(.title3)
                    Text("During the second world war Steven is...").font(.caption)
                    Spacer()
                    Button(action: {}, label : {Text("Read more")})
                }.padding()
                Spacer()
                Image("history3").resizable().scaledToFit().frame(width: 150, alignment: .center)
            }.background(Color.white).clipped().shadow(radius: 3)
            
            HStack {
                VStack(alignment: .leading) {
                    Text("The migration").font(.title3)
                    Text("Looking back to 1928 when our...").font(.caption)
                    Spacer()
                    Button(action: {}, label : {Text("Read more")})
                }.padding()
                Spacer()
                Image("history4").resizable().scaledToFit().frame(width: 150, alignment: .center)
            }.background(Color.white).clipped().shadow(radius: 3)
        }
        .navigationTitle("Family History")
    }
}

struct FamilyHistoryView_Previews: PreviewProvider {
    static var previews: some View {
        FamilyHistoryView()
    }
}
