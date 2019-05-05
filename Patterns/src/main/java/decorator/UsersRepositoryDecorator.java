package decorator;

import singleton.best_practise.interfaces.CrudDao;
import singleton.best_practise.models.User;
import singleton.best_practise.repositories.UsersRepository;

import java.sql.SQLException;
import java.util.List;

public class UsersRepositoryDecorator implements CrudDao {
    protected UsersRepository repository = UsersRepository.getInstance();

    @Override
    public Object getByName(String login) throws SQLException {
        return repository.getByName(login);
    }

    @Override
    public void update(Object model, int index) throws SQLException {
        repository.update((User) model, index);
    }

    @Override
    public void add(Object model) throws SQLException {
        repository.add((User) model);
    }

    @Override
    public void delete(int index) throws SQLException {
        repository.delete(index);
    }

    @Override
    public List getAll() throws SQLException {
        return repository.getAll();
    }
}
