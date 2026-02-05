package tacos.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tacos.Ingredient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

//@Repository
public class JdbcIngredientRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    @Override
    public List<Ingredient> findAll() {
        String sql = "SELECT id, name, type FROM ingredient ORDER BY id DESC";
        return jdbcTemplate.query(sql, this::mapRowToIngredient);
    }

    private Ingredient mapRowToIngredient(ResultSet row, int rowNum) throws SQLException {

        return new Ingredient(
                row.getString("id"),
                row.getString("name"),
                Ingredient.Type.valueOf(row.getString("type"))
        );
    }

//    @Override
    public Optional<Ingredient> findById(String id) {
        String sql = "select id, name, type from ingredient where id = ?";
        List<Ingredient> results = jdbcTemplate.query(sql, this::mapRowToIngredient, id);
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

//    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update("INSERT INTO ingredient (id,name,type) values (?,?,?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString());
        return ingredient;
    }
}
