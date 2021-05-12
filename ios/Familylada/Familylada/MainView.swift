//
//  MainView.swift
//  Familylada
//
//  Created by Kristiyan Strahilov on 12.05.21.
//

import SwiftUI

struct MainView: View {
    @State var profileLink = false
    @State var settingsLink = false
    
    var body: some View {
        NavigationView {
            TabView {
                HomeView()
                    .tabItem{
                        Image(systemName: "house")
                        Text("Home")
                    }
                GalleryView()
                    .tabItem{
                        Image(systemName: "photo.on.rectangle")
                        Text("Gallery")
                    }
                EventsView()
                    .tabItem{
                        Image(systemName: "clock")
                        Text("Events")
                    }
                MembersView()
                    .tabItem{
                        Image(systemName: "person.3")
                        Text("Members")
                    }
                FamilyPlusView()
                    .tabItem{
                        Image(systemName: "person.2.square.stack")
                        Text("Family+")
                    }
            }
            
            .background(
                NavigationLink(destination: ProfileView(), isActive: $profileLink) {}
            )
            .background(
                NavigationLink(destination: SettingsView(), isActive: $settingsLink) {}
            )
            .navigationBarTitle("Familylada", displayMode: .large)
            .toolbar {
                ToolbarItem(placement: .navigationBarLeading) {
                    Button(action: {
                        profileLink = true
                    }) {
                        Image(systemName: "person.crop.circle")
                    }
                }
                
                ToolbarItem(placement: .navigationBarTrailing) {
                    Button(action: {
                        settingsLink = true
                    }) {
                        Image(systemName: "gear")
                    }
                }
            }
        }
    }
}

struct MainView_Previews: PreviewProvider {
    static var previews: some View {
        MainView()
    }
}
