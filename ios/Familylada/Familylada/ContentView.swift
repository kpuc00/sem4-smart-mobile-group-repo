//
//  ContentView.swift
//  Familylada
//
//  Created by Kristiyan Strahilov on 12.05.21.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        NavigationView{
            Form{
                Text("FamilyLada")
            }
            .navigationBarTitle("Familylada")
            .toolbar {
                ToolbarItem(placement: .navigationBarTrailing) {
                    Button(action: {
                        print("settings button")
                    }){Image(systemName: "gear")}
                    
                }
                
                ToolbarItem(placement: .navigationBarLeading) {
                    Button(action: {
                        print("profile page button")
                    }){Image(systemName: "person.crop.circle")}
                }
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
