//
//  EventCardView.swift
//  Familylada
//
//  Created by Kristian Hadzhikolev on 12.05.21.
//

import SwiftUI

struct EventCardView: View{
    let card: EventCard
    
    var body: some View {
        ZStack{
            RoundedRectangle(cornerRadius: /*@START_MENU_TOKEN@*/25.0/*@END_MENU_TOKEN@*/, style: /*@START_MENU_TOKEN@*/.continuous/*@END_MENU_TOKEN@*/)
                .fill(Color.white)
                .shadow(radius: /*@START_MENU_TOKEN@*/10/*@END_MENU_TOKEN@*/)
            
            VStack{
                Image(systemName: card.image)
                    .resizable()
                    .frame(width: 50.0, height: 50.0)
                Text(card.title)
                    .font(.title3)
                    .foregroundColor(.gray)
            }
            .padding(20)
            .multilineTextAlignment(.center)
        }
        .frame(width: 175, height: 175)
    }
    
}

struct EventCardView_Preview: PreviewProvider {
    static var previews: some View{
        EventCardView(card: EventCard.example)
    }
}
