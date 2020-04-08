
var webdriver = require('selenium-webdriver');
const {Builder} = require('selenium-webdriver');
const chrome = require('selenium-webdriver/chrome');
chrome.setDefaultService(new chrome.ServiceBuilder('./node_modules/chromedriver/lib/chromedriver/chromedriver.exe').build());
const MongoClient = require("mongodb").MongoClient;

var until = webdriver.until;
var By = webdriver.By;


const mongoClient = new MongoClient("mongodb://localhost:27017/");
mongoClient.connect(function(err, client){
 
    if(err){
        return console.log(err);
    }
    
    //////////////////////////////////
    //////////////////////////////////
    const db = client.db("shazam_parser");
    const collection = db.collection("shazam_rating");

    var today_date = new Date();
    var dataToDatabase = new Array();

    (async function test(){
        let driver = await new Builder().forBrowser('chrome').build();
    
        await driver.get('https://www.shazam.com/ru/charts/top-200/ukraine');
        // await driver.sleep(5000);
    
        let t1 = await driver.wait(until.elementLocated(By.className('last-visible')), 15000);
        // let txt1 = await t1.getText(); 
    
        
        let elements = await driver.findElement({tagName : 'main'}); //.getAttribute('innerHTML');
        let list_of_songs = await elements.findElements({tagName : 'article'});
    
        

        for (let i = 0; i < 50; i++) { 
            

            var e = list_of_songs[i];
            //получаю ссылку на песню. ВАЖНО! Не у всех композиций есть ссылка, поэтому добавляю обаботчик ошибок
            var temp_song = await e.findElement({className: "title"});
            var temp_title__a = await temp_song.findElement({tagName: "a"});             
            var artist_title = await temp_title__a.getText();
    
            try {     
    
                var link_link = await temp_title__a.getAttribute('href');
                
            } catch (error) {
    
                var link_link = "No href for such artist!";
                
            }
            let temp_artist = await e.findElement({className: "artist"});
            let temp_artist_title = await temp_artist.findElement({className: "ellip"}).getText();
    
            try {     
                let temp_artist__a  = await temp_artist.findElement({tagName: "a"});
                var song_link = await temp_artist__a.getAttribute('href');
                
            } catch (error) {
                
                var song_link = "No href for such song!";
                
            }

            dataToDatabase.push({date : today_date, rate : i+1, artist : artist_title, song : temp_artist_title, artist_lnk : link_link, song_lnk : song_link});
        }

        
        collection.insertMany(dataToDatabase, function(err, results){
              
            console.log(results);
            client.close();
        });


        })();

    ///////////////////////////////////
    ///////////////////////////////////

});

