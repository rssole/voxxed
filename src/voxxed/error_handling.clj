(ns voxxed.error-handling
  (:import (java.nio.file Files)))

(defn delete-file [file]
  (try
    (Files/delete file)
    (catch Exception e {:cause e :input file})))

