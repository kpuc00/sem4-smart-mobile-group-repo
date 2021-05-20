//
//  FamilyTreeView.swift
//  Familylada
//
//  Created by Kristiyan Strahilov on 20.05.21.
//

import SwiftUI

struct FamilyTreeView: View {
    var body: some View {
        Image("tree")
            .resizable()
            .scaledToFit()
            .navigationTitle("Family Tree")
            
    }
}

struct FamilyTreeView_Previews: PreviewProvider {
    static var previews: some View {
        FamilyTreeView()
    }
}
