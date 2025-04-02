package hu.pte.mik.prog4.zh1.service;

import hu.pte.mik.prog4.zh1.model.Food;
import hu.pte.mik.prog4.zh1.repository.FoodRepository;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class FoodService {

    private static final Logger LOGGER = Logger.getLogger(FoodService.class.toString());

    private final FoodRepository foodRepository;

    public FoodService() {
        this.foodRepository = FoodRepository.getInstance();
    }

    public Food findById(Long id) {
        return this.foodRepository.findById(id);
    }

    public List<Food> findAll() {
        return this.foodRepository.findAll();
    }

    public Food save(String restaurantName, String foodName, String price) {
        return this.foodRepository.create(restaurantName, foodName, price);
    }

    public Food delete(Long id) {
        return this.foodRepository.delete(id);
    }

    public void convertToXml(Object object) {
        this.checkIfSerializable(object);

        StringBuilder stringBuilder = new StringBuilder("<?xml version=\"1.0\"?>").append(System.lineSeparator());
        try {
            this.serialize(object, stringBuilder);
        } catch (IllegalAccessException e) {
            //TODO Dobjon ZH1XmlException.
        }

        LOGGER.info(stringBuilder.toString());
    }

    private void checkIfSerializable(Object object) {
        if (object == null) {
            //TODO Dobjon ZH1XmlException-t üzenettel, hogy az object null.
        }

        //TODO Nézze meg, hogy a class annotávla van-e a ZH1Serializable annotációval és ha nem dobjon ZH1XmlException-t üzenettel.
    }

    private void serialize(Object object, StringBuilder stringBuilder) throws IllegalAccessException {
        Class<?> clazz = object.getClass();

        //TODO Ha a ZH1Serializable annotációnak van text nevű mezője, akkor szedje ki annak az értékét, ha nincs, akkor a class nevét használja és adja át az értékét az alábbi classKey változónak.
        String classKey = "";
        this.appendStartTag(stringBuilder, classKey);
        stringBuilder.append(System.lineSeparator());
        List<Field> fields = new ArrayList<>();
        Collections.addAll(fields, clazz.getDeclaredFields());

        for (Field field : fields) {
            //TODO Nézze meg, hogy a field annotávla van-e a ZH1Element annotációval és csak akkor hajtsa végre a for ciklusban található kódot, ha van ilyen annotációja.
            //TODO Tegye elérhetővé az adott field-et, majd a ciklus végén állítsa vissza a hozzáférhetőség eredeti értékét.

            //TODO Ha a ZH1Element annotációnak van text nevű mezője, akkor szedje ki annak az értékét, ha nincs, akkor a field nevét használja és adja át az értékét az alábbi key változónak.
            //TODO A Food class price field esetén az annotáció text mezőjének a neve legyen "PRICE_FT".
            String key = "";
            Object value = field.get(object);
            this.appendStartTag(stringBuilder, key);
            stringBuilder.append(value);
            this.appendEndTag(stringBuilder, key);
        }
        this.appendEndTag(stringBuilder, classKey);
    }

    private void appendStartTag(StringBuilder stringBuilder, String key) {
        stringBuilder.append("<")
                .append(key)
                .append(">");
    }

    private void appendEndTag(StringBuilder stringBuilder, String key) {
        stringBuilder.append("</")
                .append(key)
                .append(">")
                .append(System.lineSeparator());
    }

}
