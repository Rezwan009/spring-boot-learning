package tacos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tacos.entity.Taco;
import tacos.entity.TacoOrder;
import tacos.repository.IngredientRepository;
import tacos.entity.Ingredient;
import tacos.repository.OrderRepository;
import tacos.repository.TacoRepository;

import java.util.Arrays;

import static tacos.entity.Ingredient.*;

@SpringBootApplication
public class TacoCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(
            IngredientRepository repo,
            TacoRepository tacoRepo,
            OrderRepository orderRepo) {
        return (args) -> {
//            repo.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
//            repo.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
//            repo.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
//            repo.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
//            repo.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGETABLE));
//            repo.save(new Ingredient("LETC", "Lettuce", Type.VEGETABLE));
//            repo.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
//            repo.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
//            repo.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
//            repo.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
            Ingredient flourTortilla = new Ingredient("FLTO", "Flour Tortilla", Type.WRAP);
            Ingredient cornTortilla = new Ingredient("COTO", "Corn Tortilla", Type.WRAP);

            Ingredient groundBeef = new Ingredient("GRBF", "Ground Beef", Type.PROTEIN);
            Ingredient carnitas = new Ingredient("CARN", "Carnitas", Type.PROTEIN);

            Ingredient dicedTomatoes = new Ingredient("TMTO", "Diced Tomatoes", Type.VEGETABLE);
            Ingredient lettuce = new Ingredient("LETC", "Lettuce", Type.VEGETABLE);

            Ingredient cheddar = new Ingredient("CHED", "Cheddar", Type.CHEESE);
            Ingredient monterreyJack = new Ingredient("JACK", "Monterrey Jack", Type.CHEESE);

            Ingredient salsa = new Ingredient("SLSA", "Salsa", Type.SAUCE);
            Ingredient sourCream = new Ingredient("SRCR", "Sour Cream", Type.SAUCE);

//            repo.save(flourTortilla);
//            repo.save(cornTortilla);
//            repo.save(groundBeef);
//            repo.save(carnitas);
//            repo.save(dicedTomatoes);
//            repo.save(lettuce);
//            repo.save(cheddar);
//            repo.save(monterreyJack);
//            repo.save(salsa);
//            repo.save(sourCream);
            repo.saveAll(Arrays.asList(
                    flourTortilla,
                    cornTortilla,
                    groundBeef,
                    carnitas,
                    dicedTomatoes,
                    lettuce,
                    cheddar,
                    monterreyJack,
                    salsa,
                    sourCream
            ));

            Taco taco1 = new Taco();
            taco1.setName("Carnivore");
            taco1.setIngredients(Arrays.asList(
                    flourTortilla,groundBeef,carnitas,salsa,cheddar,sourCream
            ));
            tacoRepo.save(taco1);

            Taco taco2 = new Taco();
            taco2.setName("Bovine Bounty");
            taco2.setIngredients(Arrays.asList(
                    cornTortilla,groundBeef,monterreyJack,sourCream,cheddar
            ));
            tacoRepo.save(taco2);

            Taco taco3 = new Taco();
            taco3.setName("Veg-Out");
            taco3.setIngredients(Arrays.asList(
                    flourTortilla,cornTortilla,dicedTomatoes,lettuce,salsa
            ));
            tacoRepo.save(taco3);


//            TacoOrder order = new TacoOrder();
//            order.setDeliveryName("Test User");
//            order.setDeliveryStreet("123 Test Street");
//            order.setDeliveryCity("Dhaka");
//            order.setDeliveryState("BD");
//            order.setDeliveryZip("1200");
//            order.setCcNumber("4111111111111111");
//            order.setCcExpiration("12/25");
//            order.setCcCVV("123");
//
//            order.addTaco(taco1);
//            order.addTaco(taco2);
//            order.addTaco(taco3);
//
//            orderRepo.save(order);
        };
    }


//    @Bean
//    public ApplicationRunner runner(IngredientRepository repo) {
//        return args -> {
//            repo.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
//            repo.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
//            repo.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
//            repo.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
//            repo.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGETABLE));
//            repo.save(new Ingredient("LETC", "Lettuce", Type.VEGETABLE));
//            repo.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
//            repo.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
//            repo.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
//            repo.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
//        };
//    }

}
