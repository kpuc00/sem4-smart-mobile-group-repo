//
//  ContentView.swift
//  Familylada
//
//  Created by Kristiyan Strahilov on 12.05.21.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        
            TabView{
                getnavigation()
                    .tabItem{
                        Image(systemName: "house")
                        Text("Home")
                    }
                    
                    
                getnavigation()
                    .tabItem{
                        Image(systemName: "rectangle.stack.person.crop")
                        Text("Collections")
                        
                    }
                getnavigation()
                    .tabItem{
                        Image(systemName: "clock")
                        Text("Events")
                        
                    }
                
                getnavigation()
                    .tabItem{
                        Image(systemName: "person.3")
                        Text("Members")
                        
                    }
                getnavigation()
                    .tabItem{
                        Image(systemName: "questionmark.circle")
                        Text("Family+")
                        
                    }
            
        }
    }
}

@ViewBuilder
func getnavigation() -> some View {
    NavigationView{
        Text("FamilyLada")
            .toolbar {
                ToolbarItem(placement: .principal){
                    Text("Familylada")
                }
                ToolbarItem(placement: .navigationBarTrailing) {
                    Button(action: {
                        print("rightBtn")
                    }) {
                        Image(systemName: "gear")
                    }
                }
                
                ToolbarItem(placement: .navigationBarLeading) {
                    Button(action: {
                        print("leftBtn")
                    }) {
                        Image(systemName: "person.circle.fill")
                    }
                }
            }
    }
}


struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        Group {
            ContentView()
        }
    }
}
