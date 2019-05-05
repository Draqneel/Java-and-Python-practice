package decorator;

import singleton.best_practise.models.User;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashableRepositoryDecorator extends UsersRepositoryDecorator {

    @Override
    public void add(Object u){
        User newUser = (User) u;
        newUser.setSurname(md5Custom(newUser.getSurname()));
    }

    @Override
    public User getByName(String login){
        try {
            return super.repository.getByName(md5Custom(login));
        } catch (Exception e) {
            System.err.println("Incorrect login");
            e.printStackTrace();

        }
        return null;
    }

    public static String md5Custom(String st) {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(st.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            // тут можно обработать ошибку
            // возникает она если в передаваемый алгоритм в getInstance(,,,) не существует
            e.printStackTrace();
        }

        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);

        while( md5Hex.length() < 32 ){
            md5Hex = "0" + md5Hex;
        }

        return md5Hex;
    }
}
