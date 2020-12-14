package Plato.View.Menu;

public class LoginMenu extends Menu{
    public LoginMenu(Menu parentMenu) {
        super("login menu", parentMenu);
    }

    private Menu loginToAccount() {
        return new Menu("login page", this) {
            @Override
            public void show() {
                System.out.println(this.getName() + ":");
                System.out.println("If you have not an account creat one!\n" +
                        "Enter username and password:" +
                        "\nEnter back to return");
            }

            @Override
            public void execute() {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("back")) {
                    this.parentMenu.show();
                    this.parentMenu.execute();
                } else {
                    String[] splitInput = input.split("\\s");
                    this.show();
                    this.execute();
                }
            }
        };
    }
}
