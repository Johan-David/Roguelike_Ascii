package Game.Infra;

import Game.Utility.Tile;
import Game.Utility.World;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import static Game.Utility.Tile.*;
import static java.lang.Math.toIntExact;

public class SaveSystem {
    public void saveWorld(World world) throws FileNotFoundException {
        JSONObject jo = new JSONObject();
        WorldDAO worldDAO = new WorldDAO(world);

        int width = worldDAO.width();
        int height = worldDAO.height();
        // putting data to JSONObject
        jo.put("Width", width);
        jo.put("Height", height);

        // for tiles array, first create JSONArray
        JSONArray ja = new JSONArray();

        for(int y = 0; y < height; y++ ){
            for(int x = 0; x < width; x++ ){
                Map m = new LinkedHashMap(4);
                m.put("X", x);
                m.put("Y", y);
                m.put("Tile", worldDAO.tile(x,y).convertTileToString());

                // adding map to list
                ja.add(m);
            }
        }

        // putting tile array to JSONObject
        jo.put("Tiles", ja);

        // writing JSON to file:"JSONExample.json" in cwd
        PrintWriter pw = new PrintWriter("JSONExample.json");
        pw.write(jo.toJSONString());

        pw.flush();
        pw.close();
    }

    public World loadWorld(/* parameter for which world, maybe string ? */) throws IOException, ParseException{
        // parsing file "JSONExample.json"

        Object obj = new JSONParser().parse(new FileReader("JSONExample.json"));

        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;
        long width = (long) jo.get("Width");
        long height= (long) jo.get("Height");
        System.out.println(width + " " + height);

        // getting tiles array
        JSONArray ja = (JSONArray) jo.get("Tiles");

        // iterating phoneNumbers
        Iterator itr2 = ja.iterator();
        Tile[][] tiles = new Tile[toIntExact(width)][toIntExact(height)];
        while (itr2.hasNext())
        {
            Iterator itr1 = ((Map) itr2.next()).entrySet().iterator();
            while (itr1.hasNext()) {
                Map.Entry pair = (Map.Entry) itr1.next();
                long x = (long) pair.getValue();
                pair = (Map.Entry) itr1.next();
                long y = (long) pair.getValue();
                pair = (Map.Entry) itr1.next();
                String tileString = (String) pair.getValue();
                tiles[toIntExact(x)][toIntExact(y)] = convertStringToTile(tileString);
            }
        }
        return new World(tiles, null);

    }

    private Tile convertStringToTile(String tileName){
        if(tileName.equals("FLOORDAO")){
            return FLOOR;
        }else if(tileName.equals("WALLDAO")){
            return WALL;
        } else if(tileName.equals("ITEMDAO")) {
            return ITEM;
        }
        return FLOOR;
    }
}
