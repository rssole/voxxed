(ns voxxed.support.polymorph
  (:import (javax.swing JFrame JPanel JLabel JButton JRadioButton)))

(defn a-window []
  (let [win (JFrame.)
        panel (JPanel.)
        label (JLabel. "Who'd say? A label...")
        btn (JButton. "Surprisingly... a button")
        rbtn (JRadioButton. "And of course... radio :)")]
    (doto panel
         (.add label)
         (.add btn)
         (.add rbtn))
    (.add win panel)
    (.pack win)
    {:win win :label label :btn btn :rbtn rbtn}))