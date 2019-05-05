package decorator;

import singleton.best_practise.models.User;


public class MainDecorator {
    public static void main(String[] args) {
        HashableRepositoryDecorator repositoryDecorator = new HashableRepositoryDecorator();

        repositoryDecorator.add(User.builder()
                                    .name("test")
                                    .surname("test")
                                    .age(21)
                                    .isHuman(false)
                                    .build());

    }
}
