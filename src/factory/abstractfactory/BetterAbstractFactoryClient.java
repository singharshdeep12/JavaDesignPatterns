package factory.abstractfactory;

public class BetterAbstractFactoryClient {

    public static void main(String[] args) {
        createCloudResource(new GCPResources(),Capacity.MICRO,32);
    }

    static void createCloudResource(CloudResourceFactory factory,
                             Capacity capacity,int gbSize){
        Instance instance = factory.createInstance(capacity);
        instance.attachStorage(factory.createStorage(gbSize));
        instance.start();
        instance.stop();
    }

}

abstract class CloudResourceFactory{
    abstract Storage createStorage(int gbs);
    //Capacity is enum
    abstract Instance createInstance(Capacity capacity);
}

enum Capacity{
    MICRO,SMALL,MEDIUM,LARGE;
}

class AwsResources extends CloudResourceFactory{
    @Override
    Storage createStorage(int gbs) {
        return new S3(gbs);
    }

    @Override
    Instance createInstance(Capacity capacity) {
        return new EC2(capacity);
    }
}

class GCPResources extends CloudResourceFactory{
    @Override
    Storage createStorage(int gbs) {
        return new GoogleCloudStorage(gbs);
    }

    @Override
    Instance createInstance(Capacity capacity) {
        return new GoogleComputeCloud(capacity);
    }
}


abstract class Instance{
    Capacity capacity;
    Storage storage;
    abstract void start();
    abstract void stop();
    abstract void attachStorage(Storage s);
}

class EC2 extends Instance{
    public EC2(Capacity capacity){
        System.out.println("Created EC2 instance");
        this.capacity=capacity;
    }

    @Override
    void start() {
        System.out.println("EC2 is starting...");
    }

    @Override
    void stop() {
        System.out.println("...EC2 stopped");
    }

    @Override
    void attachStorage(Storage s) {
        this.storage = s;
        System.out.println(storage.getClass().getSimpleName()
                + " attached to EC2");
    }
}

class GoogleComputeCloud extends Instance{
    public GoogleComputeCloud(Capacity capacity) {
        System.out.println("Created GoogleComputeCloud instance");
        this.capacity=capacity;
    }

    @Override
    void start() {
        System.out.println("GoogleComputeCloud is starting...");
    }

    @Override
    void stop() {
        System.out.println("...GoogleComputeCloud stopped");
    }

    @Override
    void attachStorage(Storage s) {
        this.storage = s;
        System.out.println(storage.getClass().getSimpleName()
                + " attached to GoogleComputeCloud");
    }
}


abstract class Storage{
    int size;
}

class S3 extends Storage{
    S3(int gbs){
        this.size = gbs;
    }
}

class GoogleCloudStorage extends Storage{
    GoogleCloudStorage(int gbs){
        this.size = gbs;
    }
}