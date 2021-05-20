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
        ScrollView{
            HStack {
                Image(systemName: "magnifyingglass")
                TextField("Search...", text: $text).disableAutocorrection(true)
            }.padding().overlay(Capsule(style: .continuous).stroke(Color.gray))
        }.padding()
        .navigationTitle("Family History")
    }
}

struct FamilyHistoryView_Previews: PreviewProvider {
    static var previews: some View {
        FamilyHistoryView()
    }
}
