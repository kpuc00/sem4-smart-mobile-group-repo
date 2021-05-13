import SwiftUI

struct EventView: View {
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
                        Alert(title: Text("Important message"), message: Text("Wear sunscreen"), dismissButton: .default(Text("Got it!")))
                    }, label: {
                        Text("+")
                            .font(.system(.largeTitle))
                            .frame(width: 77, height: 70)
                            .foregroundColor(Color.white)
                            .padding(.bottom, 7)
                    })
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

struct EventView_Previews: PreviewProvider {
    static var previews: some View {
        Group {
            EventView()
        }
    }
}
