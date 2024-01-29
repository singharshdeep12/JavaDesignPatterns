package factory.factory;


//----Directory / Client class
public class FactoryClient {

    public static void main(String[] args) {
        printMessage(new JSONMessageFactory());
        printMessage(new TextMessageFactory());
    }

    static void printMessage(MessageFactory factory){
        System.out.println(factory.getMessage());
    }
}

//---Factories that will create objects
abstract class MessageFactory{
    public Message getMessage(){
        Message msg = createMessage();
        //Additional Processing of message
        //like encryption, adding headers etc
        return msg;
    }
    public abstract Message createMessage();
}

class TextMessageFactory extends MessageFactory{
    @Override
    public Message createMessage() {
        return new TextMessage();
    }
}

class JSONMessageFactory extends MessageFactory{
    @Override
    public Message createMessage() {
        return new JSONMessage();
    }
}




//---Objects to be created by Factory
abstract class Message{
    //some methods and fields
}

class TextMessage extends Message{}

class JSONMessage extends Message{}
