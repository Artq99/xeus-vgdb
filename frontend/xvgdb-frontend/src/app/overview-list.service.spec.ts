import { TestBed, inject } from '@angular/core/testing';

import { OverviewListService } from './overview-list.service';

describe('OverviewListService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [OverviewListService]
    });
  });

  it('should be created', inject([OverviewListService], (service: OverviewListService) => {
    expect(service).toBeTruthy();
  }));
});
