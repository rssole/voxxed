(ns voxxed.macros)

;(use 'voxxed.macros :reload)

;...remember Clojure being homoiconic?
;
;
; Always and only manipulation with Clojure code

(defmacro foreach [[sym coll] & body]
  `(loop [coll# ~coll]
     (when-let [[~sym & xs#] (seq coll#)]
       ~@body
       (recur xs#))))

(clojure.pprint/pprint (macroexpand
  '(foreach [ch ["Here is a simple macro"]]
           (println ch))))

;With big power - comes responsibility ... don't go berserk :)

'(clojure.pprint/pprint (macroexpand
  '(->> "Here is another one but much more useful"
       (filter #(not (#{\a \e \i \o \u} %)))
       (map #(Character/toUpperCase %))
       (apply str))))

;...make Clojure inifinitely extensible, PERIOD!