(ns voxxed.support.polymorph
  (:import (javax.swing JFrame JPanel JLabel JButton JRadioButton)
           (java.awt.event ActionListener MouseAdapter)))

(defn a-window [event-handler]
  (let [win (JFrame. "Mighty App")
        panel (JPanel.)
        label (JLabel. "Who'd say? A label...")
        btn (JButton. "Surprisingly... a button")
        rbtn (JRadioButton. "And of course... radio :)")
        handler (reify ActionListener
                  (actionPerformed [_ e]
                    (event-handler e)))]
    (.addActionListener btn handler)
    (.addActionListener rbtn handler)
    (.addMouseListener label (proxy [MouseAdapter] []
                               (mousePressed [e]
                                 (event-handler e))))
    (doto panel
      (.add label)
      (.add btn)
      (.add rbtn))
    (doto win
      (.add panel)
      (.setDefaultCloseOperation JFrame/DISPOSE_ON_CLOSE)
      (.pack)
      (.setVisible true))
    {:win win :label label :btn btn :rbtn rbtn}))