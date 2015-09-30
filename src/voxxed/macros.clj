(ns voxxed.macros)

;(use 'voxxed.macros :reload)

(defmacro foreach [[sym coll] & body]
  `(loop [coll# ~coll]
     (when-let [[~sym & xs#] (seq coll#)]
       ~@body
       (recur xs#))))

(clojure.pprint/pprint (macroexpand
  '(foreach [ch ["Here is a simple macro"]]
           (println ch))))

'(clojure.pprint/pprint (macroexpand
  '(->> "Here is another one but much more useful"
       (filter #(not (#{\a \e \i \o \u} %)))
       (map #(Character/toUpperCase %))
       (apply str))))