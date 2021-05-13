//
//  EventCard.swift
//  Familylada
//
//  Created by Kristian Hadzhikolev on 12.05.21.
//

import Foundation

struct EventCard {
    let image: String
    let title: String
    
    static var example: EventCard {
        EventCard(image: "clock", title:"Event 1")
    }
}
