//
//  EventsView.swift
//  Familylada
//
//  Created by Kristiyan Strahilov on 12.05.21.
//

import SwiftUI

struct EventsView: View {
    @State private var showingAlert = false
    
    var body: some View {
        VStack{
            Spacer()
            HStack{
                EventCardView(card: EventCard.example)
                EventCardView(card: EventCard.example)
            }
            HStack{
                EventCardView(card: EventCard.example)
                EventCardView(card: EventCard.example)
            }
            HStack{
                EventCardView(card: EventCard.example)
                EventCardView(card: EventCard.example)
            }
            
            VStack {
                Spacer()
                HStack {
                    Spacer()
                    Button(action: {
                        showingAlert = true
                    }, label: {
                        Text("+")
                            .font(.system(.largeTitle))
                            .frame(width: 77, height: 70)
                            .foregroundColor(Color.white)
                            .padding(.bottom, 7)
                    })
                    .alert(isPresented: $showingAlert) {
                                Alert(title: Text("Add new Event"), message: Text("hmmm"), dismissButton: .default(Text("Got it!")))
                            }
                    .background(Color.blue)
                    .cornerRadius(38.5)
                    .padding()
                    .shadow(color: Color.black.opacity(0.3),
                            radius: 3,
                            x: 3,
                            y: 3)
                }
            }
        }
        
    }
}

struct EventsView_Previews: PreviewProvider {
    static var previews: some View {
        EventsView()
    }
}
