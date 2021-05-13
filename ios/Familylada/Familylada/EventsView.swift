import SwiftUI

struct EventsView: View {
    @State private var showsAlert = false
    
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
                        self.showsAlert = true
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
                    .alert(isPresented: $showsAlert, TextAlert(title: "Event Details", action: {
                        print("Callback \($0 ?? "canceled")")
                        let input = $0 ?? ""
                        if(input != ""){
                            print("Adding event: " + input)
                        }
                    }))
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
