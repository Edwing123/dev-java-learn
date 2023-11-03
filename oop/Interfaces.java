
public class Interfaces {

    public static void main(String[] args) {
        final UserRepository userRepository = new InMemoryUserRepository();
        System.err.println(userRepository.findByName("Edwin"));
    }
}

record User(String name) {

}

interface UserRepository {

    User findByName(String name);
}

class InMemoryUserRepository implements UserRepository {

    @Override
    public User findByName(String name) {
        return new User(name);
    }
}
