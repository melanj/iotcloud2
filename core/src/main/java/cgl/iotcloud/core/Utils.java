package cgl.iotcloud.core;

import org.ho.yaml.Yaml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

public class Utils {
    private static Logger LOG = LoggerFactory.getLogger(Utils.class);

    public static Map findAndReadConfigFile(String name, boolean mustExist) {
        try {
            HashSet<URL> resources = new HashSet<URL>(findResources(name));
            if (resources.isEmpty()) {
                if (mustExist) throw new RuntimeException("Could not find config file on classpath " + name);
                else return new HashMap();
            }
            if (resources.size() > 1) {
                throw new RuntimeException("Found multiple " + name + " resources."
                        + resources);
            }
            URL resource = resources.iterator().next();
            Map ret = (Map) Yaml.load(new InputStreamReader(resource.openStream()));

            if (ret == null) ret = new HashMap();

            return new HashMap(ret);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<URL> findResources(String name) {
        try {
            Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(name);
            List<URL> ret = new ArrayList<URL>();
            while (resources.hasMoreElements()) {
                ret.add(resources.nextElement());
            }
            return ret;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map findAndReadConfigFile(String name) {
        return findAndReadConfigFile(name, true);
    }

    public static Map readDefaultConfig() {
        return findAndReadConfigFile("defaults.yaml", true);
    }

    public static Map readConfig() {
        Map ret = readDefaultConfig();
        String confFile = System.getProperty("iot.conf.file");
        Map storm;
        if (confFile==null || confFile.equals("")) {
            storm = findAndReadConfigFile("iot.yaml", false);
        } else {
            storm = findAndReadConfigFile(confFile);
        }
        ret.putAll(storm);
        return ret;
    }

    public static ISensor loadSensor(URL jar, String className, ClassLoader parent) {
        ClassLoader loader = URLClassLoader.newInstance(new URL[]{jar}, parent);
        Class<?> clazz;
        try {
            clazz = Class.forName(className, true, loader);
            Class<? extends ISensor> runClass = clazz.asSubclass(ISensor.class);
            // Avoid Class.newInstance, for it is evil.
            Constructor<? extends ISensor> ctor = runClass.getConstructor();
            return ctor.newInstance();
        } catch (ClassNotFoundException x) {
            LOG.error("Sensor class cannot be found {}", className, x);
            throw new RuntimeException("Sensor class cannot be found " + className, x);
        } catch (InstantiationException x) {
            LOG.error("Sensor class cannot be instantiated {}", className, x);
            throw new RuntimeException("Transport class cannot be instantiated " + className, x);
        } catch (Exception e) {
            LOG.error("Error loading the class {}", className, e);
            throw new RuntimeException("Error loading the class " + className, e);
        }
    }
}
