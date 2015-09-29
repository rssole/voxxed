(ns voxxed.macros)

(defmacro foreach [[sym coll] & body]
  `(loop [coll# ~coll]
     (when-let [[~sym & xs#] (seq coll#)]
       ~@body
       (recur xs#))))

(macroexpand
  '(foreach [ch ["Here is a simple macro"]]
           (println ch)))

(macroexpand
  '(->> "Here is another one but much more useful"
       (filter #(not (#{\a \e \i \o \u} %)))
       (map #(Character/toUpperCase %))
       (apply str)))