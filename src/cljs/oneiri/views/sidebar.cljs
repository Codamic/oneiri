(ns oneiri.views.sidebar
  (:require [oneiri.views.grommet :as g]))


(defn sidebar
  "The small panel on the right side (ltr)."
  []
  [g/sidebar {:colorIndex "neutral-3-a"
              :className  ""
              :fixed true
              :size "xsmall"}
   [g/footer
    [g/anchor {:icon (g/icon "SettingsOption" {:size "medium"})
               :href "/settings"}]]])
