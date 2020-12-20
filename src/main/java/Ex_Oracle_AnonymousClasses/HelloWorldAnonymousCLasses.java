package Ex_Oracle_AnonymousClasses;

public class HelloWorldAnonymousCLasses {

    interface HelloWord {
        public void greet();
        public void greetSomeone(String name);
    }

    public void sayHello() {
        HelloWord italianGreeting = new HelloWord() {
            String name = "Mondo";

            @Override
            public void greet() {
                greetSomeone(name);
            }

            @Override
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Ciao" + " " + name);
            }
        };

        italianGreeting.greet();
        italianGreeting.greetSomeone("Cristian");
    }


    public static void main(String[] args) {
        HelloWorldAnonymousCLasses app =
                new HelloWorldAnonymousCLasses();
        app.sayHello();
    }
}
