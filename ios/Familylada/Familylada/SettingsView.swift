//
//  SettingsView.swift
//  Familylada
//
//  Created by Kristiyan Strahilov on 12.05.21.
//

import SwiftUI

struct SettingsView: View {
    @State private var enableLocation = false
    @State private var enableStorage = true
    @State private var enableDarkMode = false
    
    var skins = ["Skin 1", "Skin 2", "Skin 3"]
    @State private var selectedSkin = 0
    
    var body: some View {
        Form {
            Section(header: Text("Permissions")) {
                Toggle("Location", isOn: $enableLocation)
                Toggle("Storage", isOn: $enableStorage)
            }
            Section(header: Text("Appearance")) {
                Picker("Change skin", selection: $selectedSkin) {
                    ForEach(0..<skins.count) {
                        Text(skins[$0])
                    }
                }
                Toggle("Dark mode", isOn: $enableDarkMode)
            }
        }
        .navigationTitle("Settings")
    }
}

struct SettingsView_Previews: PreviewProvider {
    static var previews: some View {
        SettingsView()
    }
}
