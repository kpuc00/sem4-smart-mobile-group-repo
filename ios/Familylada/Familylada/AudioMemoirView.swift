//
//  AudioMemoirView.swift
//  Familylada
//
//  Created by Kristiyan Strahilov on 20.05.21.
//

import SwiftUI

struct AudioMemoirView: View {
    var body: some View {
        ZStack {
            ScrollView {
                HStack {
                    VStack(alignment: .leading) {
                        Text("Greeting")
                        Text("from John Doe").foregroundColor(.gray)
                    }
                    Spacer()
                    Image(systemName: "play.circle")
                }.padding().overlay(Capsule(style: .continuous).stroke(Color.gray))
                
                HStack {
                    VStack(alignment: .leading) {
                        Text("Untitled")
                        Text("from Jane Doe").foregroundColor(.gray)
                    }
                    Spacer()
                    Image(systemName: "play.circle")
                }.padding().overlay(Capsule(style: .continuous).stroke(Color.gray))
                
                HStack {
                    VStack(alignment: .leading) {
                        Text("Goodnight wishes")
                        Text("from Alex").foregroundColor(.gray)
                    }
                    Spacer()
                    Image(systemName: "play.circle")
                }.padding().overlay(Capsule(style: .continuous).stroke(Color.gray))
                HStack {
                    VStack(alignment: .leading) {
                        Text("Untitled")
                        Text("from Lorettalorna de Merida").foregroundColor(.gray)
                    }
                    Spacer()
                    Image(systemName: "play.circle")
                }.padding().overlay(Capsule(style: .continuous).stroke(Color.gray))
            }
            VStack {
                Spacer()
                HStack {
                    Spacer()
                    Button(action: {}, label: {
                        Image(systemName: "largecircle.fill.circle").foregroundColor(.white).padding()
                    }).background(Color.yellow).cornerRadius(30)
                }
            }.padding()
        }.padding()
        .navigationTitle("Audio Memoir")
    }
}

struct AudioMemoirView_Previews: PreviewProvider {
    static var previews: some View {
        AudioMemoirView()
    }
}
