 #MovieFlix 
 - A web application which displays movies and tv series from imdb with facilities to comment on a specific title and rate it by users.
 
 => Functionalities
 Roles:
 1. Admin:
 - Create a record or a list of records of movies and tv series
 - Update a record of movie or tv series
 - Delete a record of movie or tv series 
 
 2. User:
 - Create a profile
 - Edit a profile
 - Delete a profile
 - Find movies or tv series by title search
 - Filter records which are only movies
 - Filter records which are only tv series
 - Filter records by year
 - Filter records by actor
 - Filter records by genre
 - Filter records by language
 - Filter records by writer
 - Filter records by director
 - Filter records by country
 - Sort records by imdbRatigs
 - Sort records by imdbVotes
 - Sort records by year
 - Add a comment on a specific title
 - View Comments on a specific title
 - Rate a title out of 5 stars
 - View top rated records
 - View Average Ratings of a specific record
 
 URLs:
 Admin: (/MovieFlix-0.0.1/api/admin/records)
 1. createRecord - (POST) Add multiple titles (also includes single title)
 2. updateRecord - (PUT - /{id})Edit a record with the specific "id"	
 3. deleteRecord - (DELETE - /{id}) Delete a record with the specific "id"
 4. findAll 		- (GET) Return all records from the database			   		
 5. findByTitle	- (GET - /{title})Returns a record with the specific "title"
 
 User: (/MovieFlix-0.0.1/api/user/)
 1. findAll() - (GET - /records)returns all the movies and TV series			  									
 2. findByTitle - (GET - /records/{title}) returns the record with the specific "title" 							
 3. findAllMovies - (GET - /records/movies) return records which are only of type movie 							
 4. findAllTvSeries - (GET - /records/tvseries) return records which are only of type series						
 5. sortByImdbRatings - (GET - /records/imdbRatings) return all the records with descending order of imdbRatings	
 6. sortByImdbVotes - (GET - /records/imdbVotes) return all the records with descending order of imdbVotes 			
 7. sortByYear - (GET - /records/year) return all the records with latest first										
 8. filterByYear - (GET - /records/year/{year}) return all the records of that specific "year"						
 9. filterByActor - (GET - /records/actor/{actor}) return all the records of that specific "actor"					
 10. filterByGenre - (GET - /records/genre/{genre}) return all the records of that specific "genre"					
 11. addComment - (POST - /records/comment) adds a comment for the specific title by the specific user				
 12. viewComments - (GET - /records/comment/{title}) return all the comments of that specific "title"				
 13. addRating - (POST - /records/rating) adds a rating for the spcific title by the specific user					
 14. viewTopRated - (GET - /records/rating/topRated) return all the records with the highest ratings first			
 15. averageRating - (GET - /records/rating/{title}) returns average rating given by users to the specific "title"
