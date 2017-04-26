(ns oneiri.views.navbar
  (:require
   [oneiri.views.grommet :refer [header box icon button title search]]
   [oneiri.utils         :refer [dir-class]]))

(defn navbar
  [lang]
  [header {:full       "horizontal"
           :alignSelf  "stretch"
           :flex       true
           :pad        "small"
           :size       "small"
           :className  (dir-class lang)}

   [title
    [button {:icon  (icon "Fan")
             :plain true
             :on-click #(js/alert "Menu")}]]

   [button {:icon  (icon "StandardsPerformance")
            :plain true
            :on-click #(js/alert "asd")}]

   [box {:flex       true
         :justify    "end"
         :direction  "row"
         :responsive false}
    [search {:inline      true
             :fill        true
             :iconAlign   "start"
             :size        "medium"
             :dropAlign   (clj->js {:right "right"})
             :placeHolder "Search"}]]
   [button {:icon  (icon "Menu")
            :plain true
            :on-click #(js/alert "Menu")}]

])
