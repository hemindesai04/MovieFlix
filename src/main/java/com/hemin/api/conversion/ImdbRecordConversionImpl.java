package com.hemin.api.conversion;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hemin.api.entities.ActorMaster;
import com.hemin.api.entities.CountryMaster;
import com.hemin.api.entities.DirectorMaster;
import com.hemin.api.entities.GenreMaster;
import com.hemin.api.entities.LanguageMaster;
import com.hemin.api.entities.WriterMaster;
import com.hemin.api.entities.imdbRecord;
import com.hemin.api.entities.imdbRecordDTO;
import com.hemin.api.repositories.imdbRepository;

@Service
public class ImdbRecordConversionImpl implements ImdbRecordConversion {
	
	@Autowired
	private imdbRepository repository;
	
	// method to convert dto object to entity object
		public imdbRecord dto2entity(imdbRecordDTO record){
			imdbRecord newRecord = new imdbRecord();
			
			newRecord.setTitle(record.getTitle());		//title
			
			if(record.getYear().equals("N/A"))
				newRecord.setYear(null);
			else{
				newRecord.setYear(record.getYear());	//year
			}
				
			if(record.getReleased().equals("N/A"))
				newRecord.setReleased(null);
			else{
				SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
				try {
					newRecord.setReleased(formatter.parse(record.getReleased()));	//releasedDate
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			
			if(record.getRuntime().equals("N/A"))
				newRecord.setRuntime(0);
			else{
				String firstWord = null;
				if(record.getRuntime().contains(" ")){
				   firstWord= record.getRuntime().substring(0, record.getRuntime().indexOf(" ")); 	// runtime
				}
				newRecord.setRuntime(Integer.valueOf(firstWord));
			}

			if(record.getPlot().equals("N/A"))
				newRecord.setPlot(null);
			else
				newRecord.setPlot(record.getPlot());	// plot
			
			if(record.getAwards().equals("N/A"))
				newRecord.setAwards(null);
			else
				newRecord.setAwards(record.getAwards());	// awards
			
			if(record.getPoster().equals("N/A"))
				newRecord.setPoster(null);
			else
				newRecord.setPoster(record.getPoster()); 	// poster
			
			if(record.getImdbRating().equals("N/A"))
				newRecord.setImdbRating(0);
			else
				newRecord.setImdbRating(Double.parseDouble(record.getImdbRating())); 	// imdbRating
				
			if(record.getImdbVotes().equals("N/A"))
				newRecord.setImdbVotes(null);
			else{
				try {
					newRecord.setImdbVotes(NumberFormat.getNumberInstance(Locale.US).parse(record.getImdbVotes())); // imdbVotes
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			
			if(record.getMetascore().equals("N/A"))
				newRecord.setMetascore(0);
			else
				newRecord.setMetascore(Integer.valueOf(record.getMetascore()));
			
			newRecord.setImdbID(record.getImdbID());	// imdbID
			
			newRecord.setType(record.getType());	// type
			
			if(record.getRated().equals("N/A"))
				newRecord.setRated(null);
			else
				newRecord.setRated(record.getRated()); 	// rated
			
			//genre
			if(record.getGenre().equals("N/A"))
				newRecord.setGenre(null);
			else{
				String[] ar = record.getGenre().split(",");
				Set<GenreMaster> gmSet = null; // genre
				for(int i=0; i<ar.length; i++){
					if(gmSet == null)
						gmSet = new HashSet<GenreMaster>();
					GenreMaster gm = repository.findByGenreName(ar[i].trim());
					if(gm == null){
						gm = new GenreMaster();
						gm.setGenreName(ar[i].trim());
						gmSet.add(gm);
					} else 
						gmSet.add(gm);
				}
				newRecord.setGenre(gmSet);
			}
			
			// actors
			if(record.getActors().equals("N/A"))
				newRecord.setGenre(null);
			else{
				String[] ar = record.getActors().split(",");
				Set<ActorMaster> amSet = null;  // actors
				for(int i=0; i<ar.length; i++){
					if(amSet == null || amSet.isEmpty())
						amSet = new HashSet<ActorMaster>();
					ActorMaster am = repository.findByActorName(ar[i].trim());
					if(am == null){
						am = new ActorMaster();
						am.setActorName(ar[i].trim());
						amSet.add(am);
					} else
						amSet.add(am);
				}
				newRecord.setActors(amSet);
			}
	 		
			//country
			if(record.getCountry().equals("N/A"))
				newRecord.setCountry(null);
			else{
				String[] ar = record.getCountry().split(",");
				Set<CountryMaster> cmSet = new HashSet<CountryMaster>();  // country
				for(int i=0;i<ar.length;i++){
					CountryMaster cm = repository.findByCountryName(ar[i].trim());
					if(cm == null){
						cm = new CountryMaster();
						cm.setCountryName(ar[i].trim());
						cmSet.add(cm);
					}
					else
						cmSet.add(cm);
				}
				newRecord.setCountry(cmSet);
			}
			
			//Director
			if(record.getDirector().equals("N/A"))
				newRecord.setDirector(null);
			else{
				String[] ar = record.getDirector().split(",");
				Set<DirectorMaster> dmSet = new HashSet<DirectorMaster>();  // director
				for(int i=0;i<ar.length;i++){
					DirectorMaster dm = repository.findByDirectorName(ar[i].trim());
					if(dm == null){
						dm = new DirectorMaster();	
						dm.setDirectorName(ar[i].trim());
						dmSet.add(dm);
					} else
						dmSet.add(dm);
				}
				newRecord.setDirector(dmSet);
			}
			
			//Writer
			if(record.getWriter().equals("N/A"))
				newRecord.setWriter(null);
			else{
				String[] ar = record.getWriter().split(",");
				Set<WriterMaster> wmSet = new HashSet<WriterMaster>();  // writer
				for(int i=0;i<ar.length;i++){
					WriterMaster wm = repository.findByWriterName(ar[i].trim());
					if(wm == null){
						wm = new WriterMaster();
						wm.setWriterName(ar[i].trim());
						wmSet.add(wm);
					}
					else
						wmSet.add(wm);
				}
				newRecord.setWriter(wmSet);
			}
			
			//language
			if(record.getLanguage().equals("N/A"))
				newRecord.setLanguage(null);
			else{
				String[] ar = record.getLanguage().split(",");
				Set<LanguageMaster> lmSet = new HashSet<LanguageMaster>();  // language
				for(int i=0;i<ar.length;i++){
					LanguageMaster lm = repository.findByLanguageName(ar[i].trim());
					if(lm == null){
						lm = new LanguageMaster();
						lm.setLang(ar[i].trim());
						lmSet.add(lm);
					} else
						lmSet.add(lm);
				}
				newRecord.setLanguage(lmSet);
			}
			
			return newRecord;
		}
		
		// method to convert entity object to DTO object
		public imdbRecordDTO entity2dto(imdbRecord record){
			imdbRecordDTO newRecord = new imdbRecordDTO();
			
			newRecord.setId(record.getId()); 
			
			newRecord.setTitle(record.getTitle()); 	// title
			
			if(record.getYear() == null)
				newRecord.setYear("N/A");
			else
				newRecord.setYear(record.getYear());	// year
			
			if(record.getReleased() == null)
				newRecord.setReleased("N/A");
			else{
				DateFormat df = new SimpleDateFormat("dd MMM yyyy");
				newRecord.setReleased(df.format(record.getReleased()));		// released
			}
			
			if(record.getRuntime() == 0)
				newRecord.setRuntime("N/A");
			else
				newRecord.setRuntime(Integer.toString(record.getRuntime()) + " min");  	// runtime
			
			if(record.getPlot() == null)
				newRecord.setPlot("N/A");
			else
				newRecord.setPlot(record.getPlot()); 	// plot
			
			if(record.getAwards() == null)
				newRecord.setAwards("N/A");
			else
				newRecord.setAwards(record.getAwards()); 	// awards
			
			if(record.getPoster() == null)
				newRecord.setPoster("N/A");
			else
				newRecord.setPoster(record.getPoster()); 	// poster
			
			if(record.getImdbRating() == 0)
				newRecord.setImdbRating("N/A");
			else
				newRecord.setImdbRating(String.valueOf(record.getImdbRating()));	// imdbRating
			
			if(record.getImdbVotes() == null)
				newRecord.setImdbVotes("N/A");
			else
				newRecord.setImdbVotes(NumberFormat.getNumberInstance(Locale.US).format(record.getImdbVotes())); 	// imdbVotes
			
			if(record.getMetascore() == 0)
				newRecord.setMetascore("N/A");
			else
				newRecord.setMetascore(Integer.toString(record.getMetascore()));	//Metascore
			
			newRecord.setImdbID(record.getImdbID()); 	//imdbID
			
			newRecord.setType(record.getType());	// type

			if(record.getRated() == null)
				newRecord.setRated("N/A");
			else
				newRecord.setRated(record.getRated()); 	// rated
			
			// genre
			if(record.getGenre() == null || record.getGenre().isEmpty())
				newRecord.setGenre("N/A");
			else{
				Set<GenreMaster> sgm = record.getGenre();
				Set<GenreMaster> tmpgm = new HashSet<GenreMaster>();
				tmpgm.addAll(sgm);
				String s = "";
				int l = tmpgm.size();
				int count = l-1;
				for (GenreMaster genreMaster : tmpgm) {
					if(count>0){
						s = s.concat(genreMaster.getGenreName() + ",");
						count--;
					}
					else
						s = s.concat(genreMaster.getGenreName());
				}
				newRecord.setGenre(s);
			}
			
			if(record.getActors().isEmpty() || record.getActors() == null)
				newRecord.setActors("N/A");
			else{
				Set<ActorMaster> sam = record.getActors();
				Set<ActorMaster> tmpam = new HashSet<ActorMaster>();
				tmpam.addAll(sam);
				String s = new String();
				int l = tmpam.size();
				int count = l-1;
				for (ActorMaster actorMaster : tmpam) {					// actors
					if(count>0){
						s = s.concat(actorMaster.getActorName()+",");
						count--;
					}else{
						s = s.concat(actorMaster.getActorName());
					}
				}
				newRecord.setActors(s);
			}
			
			// country
			if(record.getCountry()==null || record.getCountry().isEmpty())
				newRecord.setCountry("N/A");
			else{
				Set<CountryMaster> scm = record.getCountry();
				Set<CountryMaster> tmpcm = new HashSet<CountryMaster>();
				tmpcm.addAll(scm);
				String s = new String();
				int l = tmpcm.size();
				int count = l-1;
				for (CountryMaster coutnryMaster : tmpcm) {					
					if(count>0){
						s = s.concat(coutnryMaster.getCountryName()+",");
						count--;
					}else{
						s = s.concat(coutnryMaster.getCountryName());
					}
				}
				newRecord.setCountry(s);
			}
			
			//Director
			
			if(record.getDirector()==null || record.getDirector().isEmpty())
				newRecord.setDirector("N/A");
			else{
				Set<DirectorMaster> sdm = record.getDirector();
				Set<DirectorMaster> tmpdm = new HashSet<DirectorMaster>();
				tmpdm.addAll(sdm);
				String s = new String();
				int l = tmpdm.size();
				int count = l-1;
				for (DirectorMaster directorMaster : tmpdm) {					
					if(count>0){
						s = s.concat(directorMaster.getDirectorName()+",");
						count--;
					}else{
						s = s.concat(directorMaster.getDirectorName());
					}
				}
				newRecord.setDirector(s);
			}
			
			//language
			if(record.getLanguage()==null || record.getLanguage().isEmpty())
				newRecord.setLanguage("N/A");
			else{
				Set<LanguageMaster> slm = record.getLanguage();
				Set<LanguageMaster> tmplm = new HashSet<LanguageMaster>();
				tmplm.addAll(slm);
				String s = new String();
				int l = tmplm.size();
				int count = l-1;
				for (LanguageMaster languageMaster : tmplm) {					
					if(count>0){
						s = s.concat(languageMaster.getLang()+",");
						count--;
					}else{
						s = s.concat(languageMaster.getLang());
					}
				}
				newRecord.setLanguage(s);
			}
			
			// writer
			if(record.getWriter()==null || record.getWriter().isEmpty())
				newRecord.setWriter("N/A");
			else{
				Set<WriterMaster> swm = record.getWriter();
				Set<WriterMaster> tmpwm = new HashSet<WriterMaster>();
				tmpwm.addAll(swm);
				String s = new String();
				int l = tmpwm.size();
				int count = l-1;
				for (WriterMaster writerMaster : tmpwm) {					
					if(count>0){
						s = s.concat(writerMaster.getWriterName()+",");
						count--;
					}else{
						s = s.concat(writerMaster.getWriterName());
					}
				}
				newRecord.setWriter(s);
			}
			
			return newRecord;
		}


}
