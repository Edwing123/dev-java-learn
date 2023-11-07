
public class CreatingMethods {
    public static void main(String[] args) {
        var logger = new LoggerImpl();
        var jHuntersCore = new JHuntersCoreImpl(logger);
        var jHuntersCMS = new JHuntersCMSImpl(jHuntersCore);

        jHuntersCMS.createResource(
            new Resource("What's a CV?", "Learn about the so famous CV.")
        );

        jHuntersCMS.createResource(
            new Resource("What's an interview?", "Learn about the so famous job interview.")
        );
    }
}

/**
 * Methods represent the behaviour of an object,
 * and in more formal terms, in Java, methods
 * create an explicit way to communicate between
 * objects: this is known as the "message passing".
 *
 * The set of methods defined form what is known
 * as the interface of the class. The interface
 * is the way through which other classes/objects
 * can interact with the class/instance.
 *
 * A method has three required components:
 * - A return type.
 * - A name.
 * - A parameter list.
 *
 * More formally, a method is defined as:
 * <modifiers> <return type> <name> ([<type parameter1, type parameter2, ...>]) <throw list of exceptions> {
 *   <body>
 * }
 *
 * Where the modifiers, parameters and throw list are optional.
 * Keep it mind that even if it does not have parameters, the parenthesis must be kept.
 */

// Examples
interface Logger {
    public void log(String message);
}

class LoggerImpl implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}

class JHuntersCoreImpl implements JHuntersCore {
    private final Logger logger;

    public JHuntersCoreImpl(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Logger getLogger() {
        return logger;
    }
}

interface JHuntersCore {
    public Logger getLogger();
}

record Resource(String name, String description) {}

class JHuntersCMSImpl {
    private final Logger logger;

    public JHuntersCMSImpl(JHuntersCore core) {
        this.logger = core.getLogger();
    }

    public void createResource(Resource resource) {
        logger.log("Creating resource: " + resource.name());
    }

    public void deleteResource(int id) {
        logger.log("Deleting resource with id: " + id);
    }
}
