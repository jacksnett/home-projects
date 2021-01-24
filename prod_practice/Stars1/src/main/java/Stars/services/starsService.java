package Stars.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class starsService {
    public HashMap<String, String> GetAllPlanetsSpeeds()
    {
        // Doing Super Duper complicated logic.
        HashMap<String, String> hsPlanetSpeeds = new HashMap<>();
        hsPlanetSpeeds.put("sun", "1");
        hsPlanetSpeeds.put("mercury", "170,503");
        hsPlanetSpeeds.put("venus", "126,074");
        hsPlanetSpeeds.put("earth", "107,218");
        hsPlanetSpeeds.put("mars", "86,677");
        hsPlanetSpeeds.put("jupiter", "47,002");
        hsPlanetSpeeds.put("saturn", "34,701");
        hsPlanetSpeeds.put("uranus", "24,477");
        hsPlanetSpeeds.put("neptune", "19,566");

        return hsPlanetSpeeds;
    }

    public HashMap<String, String> GetAllPlanetsCircumferences()
    {
        // Doing Super Duper complicated logic.
        HashMap<String, String> hsPlanetCircumferences = new HashMap<>();
        hsPlanetCircumferences.put("sun", "4,370,005");
        hsPlanetCircumferences.put("mercury", "15,329");
        hsPlanetCircumferences.put("venus", "38,024");
        hsPlanetCircumferences.put("earth", "40,030");
        hsPlanetCircumferences.put("mars", "21,296");
        hsPlanetCircumferences.put("jupiter", "439,263");
        hsPlanetCircumferences.put("saturn", "365,882");
        hsPlanetCircumferences.put("uranus", "159,354");
        hsPlanetCircumferences.put("neptune", "154,704");

        return hsPlanetCircumferences;
    }

    public HashMap<String, String> GetAllPlanetsDistances()
    {
        // Doing Super Duper complicated logic.
        HashMap<String, String> hsPlanetDistances = new HashMap<>();
        hsPlanetDistances.put("sun", "149,598,262");
        hsPlanetDistances.put("mercury", "57,909,227");
        hsPlanetDistances.put("venus", "108,209,475");
        hsPlanetDistances.put("earth", "149,598,262");
        hsPlanetDistances.put("mars", "227,943,824");
        hsPlanetDistances.put("jupiter", "778,340,821");
        hsPlanetDistances.put("saturn", "1,426,666,422");
        hsPlanetDistances.put("uranus", "2,870,658,186");
        hsPlanetDistances.put("neptune", "4,498,396,441");

        return hsPlanetDistances;
    }
}