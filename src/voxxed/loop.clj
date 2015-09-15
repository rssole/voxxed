(ns voxxed.loop)

(defn num-of-oldtimers [residents residences]
  (count
    (for [r residents rc residences
          :when (and (= (:resc-id r) (:id rc))
                     (> (:yor r) (:age rc)))]
      r)))
