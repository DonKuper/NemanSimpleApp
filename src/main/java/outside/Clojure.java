package outside;

import org.springframework.stereotype.Service;

@Service
public class Clojure {
    public String learnMe() {
        return "(def memoized-expernsive-work (memoize yourwork))";
    }
}

